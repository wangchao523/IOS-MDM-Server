/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.notnoop.apns;

import java.util.Arrays;

import com.notnoop.apns.internal.Utilities;

/**
 * Represents an APNS notification to be sent to Apple service. This is for legacy use only
 * and should not be used in new development.
 * https://developer.apple.com/library/ios/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/Chapters/LegacyFormat.html
 *
 * This SimpleApnsNotification also only has limited error handling (by the APNS closing the connection
 * when a bad message was received) This prevents us from location the malformed notification.
 *
 * As push messages sent after a malformed notification are discarded by APNS messages will get lost
 * and not be delivered with the SimpleApnsNotification.
 *
 * @deprecated use EnhancedApnsNotification instead.
 */
@SuppressWarnings("deprecation")
@Deprecated
public class SimpleApnsNotification implements ApnsNotification {

    private final static byte COMMAND = 0;
    private final byte[] deviceToken;
    private final byte[] payload;

    /**
     * Constructs an instance of {@code ApnsNotification}.
     *
     * The message encodes the payload with a {@code UTF-8} encoding.
     *
     * @param dtoken    The Hex of the device token of the destination phone
     * @param payload   The payload message to be sent
     */
    public SimpleApnsNotification(String dtoken, String payload) {
        this.deviceToken = Utilities.decodeHex(dtoken);
        this.payload = Utilities.toUTF8Bytes(payload);
    }

    /**
     * Constructs an instance of {@code ApnsNotification}.
     *
     * @param dtoken    The binary representation of the destination device token
     * @param payload   The binary representation of the payload to be sent
     */
    public SimpleApnsNotification(byte[] dtoken, byte[] payload) {
        this.deviceToken = Utilities.copyOf(dtoken);
        this.payload = Utilities.copyOf(payload);
    }

    /**
     * Returns the binary representation of the device token.
     *
     */
    public byte[] getDeviceToken() {
        return Utilities.copyOf(deviceToken);
    }

    /**
     * Returns the binary representation of the payload.
     *
     */
    public byte[] getPayload() {
        return Utilities.copyOf(payload);
    }

    private byte[] marshall = null;
    /**
     * Returns the binary representation of the message as expected by the
     * APNS server.
     *
     * The returned array can be used to sent directly to the APNS server
     * (on the wire/socket) without any modification.
     */
    public byte[] marshall() {
        if (marshall == null)
            marshall = Utilities.marshall(COMMAND, deviceToken, payload);
        return marshall.clone();
    }

    /**
     * Returns the length of the message in bytes as it is encoded on the wire.
     *
     * Apple require the message to be of length 255 bytes or less.
     *
     * @return length of encoded message in bytes
     */
    public int length() {
        int length = 1 + 2 + deviceToken.length + 2 + payload.length;
        final int marshalledLength = marshall().length;
        assert marshalledLength == length;
        return length;
    }

    @Override
    public int hashCode() {
        return 21
               + 31 * Arrays.hashCode(deviceToken)
               + 31 * Arrays.hashCode(payload);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SimpleApnsNotification))
            return false;
        SimpleApnsNotification o = (SimpleApnsNotification)obj;
        return Arrays.equals(this.deviceToken, o.deviceToken)
                && Arrays.equals(this.payload, o.payload);
    }

    public int getIdentifier() {
        return -1;
    }

    public int getExpiry() {
        return -1;
    }
    
    @Override
    public String toString() {
        String payloadString;
        try {
            payloadString = new String(payload, "UTF-8");
        } catch (Exception ex) {
            payloadString = "???";
        }
        return "Message(Token="+Utilities.encodeHex(deviceToken)+"; Payload="+payloadString+")";
    }


}
