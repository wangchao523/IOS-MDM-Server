IOS-MDM-Server (Springmvc)
==============

Deploying iPhone and iPad Mobile Device Management for java



-------------------getCode Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.email=?
-------------------getCode End---------------
-------------------Download MobileConfig File Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
----------------------生成证书文件等的路径 start---------------------
----------------------生成证书文件等的路径 end---------------------
----------------------生成未签名的mobileconfig文件 start---------------------
----------------------生成未签名的mobileconfig文件 end---------------------
----------------------签名mobileconfig文件 start---------------------
OpenSSL：
 openssl smime -sign -in /Users/baidu/works/corey.wang/emp/out/artifacts/MDMServer_Web_exploded/mdmtool/down/c8729d83253940b6b1e7841fb717179e.mobileconfig -out /Users/baidu/works/corey.wang/emp/out/artifacts/MDMServer_Web_exploded/mdmtool/down/c8729d83253940b6b1e7841fb717179eSigned.mobileconfig -signer /Users/baidu/works/corey.wang/emp/out/artifacts/MDMServer_Web_exploded/mdmtool/ca.crt -inkey /Users/baidu/works/corey.wang/emp/out/artifacts/MDMServer_Web_exploded/mdmtool/canopass.key -certfile /Users/baidu/works/corey.wang/emp/out/artifacts/MDMServer_Web_exploded/mdmtool/ca.pem -outform der -nodetach 
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
-------------------Authenticate start---------------
Device->Server Authenticate:
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>BuildVersion</key>
	<string>15C27e</string>
	<key>Challenge</key>
	<data>
	YXBwbGU=
	</data>
	<key>DeviceName</key>
	<string>Corey.Wang-PC</string>
	<key>MessageType</key>
	<string>Authenticate</string>
	<key>Model</key>
	<string>MacBookPro12,1</string>
	<key>ModelName</key>
	<string>MacBook Pro</string>
	<key>NotOnConsole</key>
	<false/>
	<key>OSVersion</key>
	<string>10.11.2</string>
	<key>ProductName</key>
	<string>MacBookPro12,1</string>
	<key>SerialNumber</key>
	<string>C02PL2QBFVH3</string>
	<key>Topic</key>
	<string>com.apple.mgmt.External.04db860a-6ffa-4c12-bcac-e1be90a587ea</string>
	<key>UDID</key>
	<string>0A2B7C1D-0514-57C6-AD62-F72725D09C61</string>
	<key>UserID</key>
	<string>099C810D-B371-4729-8369-559BADA24F50</string>
	<key>UserLongName</key>
	<string>Corey</string>
	<key>UserShortName</key>
	<string>Corey</string>
</dict>
</plist>

Hibernate: select mdm_.id, mdm_.control as control1_, mdm_.createTime as createTime1_, mdm_.deviceId as deviceId1_, mdm_.email as email1_, mdm_.pushMagic as pushMagic1_, mdm_.pushToken as pushToken1_, mdm_.token as token1_, mdm_.topic as topic1_, mdm_.udid as udid1_, mdm_.unlockToken as unlockT11_1_ from db_mdm mdm_ where mdm_.id=?
Hibernate: update db_mdm set control=?, createTime=?, deviceId=?, email=?, pushMagic=?, pushToken=?, token=?, topic=?, udid=?, unlockToken=? where id=?
Server->Device:
<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE plist PUBLIC "-//Apple Computer//DTD PLIST 1.0//EN""http://www.apple.com/DTDs/PropertyList-1.0.dtd"><plist version="1.0"><dict></dict></plist>
-------------------Authenticate end---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
-------------------TokenUpdate start---------------
Device->Server TokenUpdate:
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>MessageType</key>
	<string>TokenUpdate</string>
	<key>NotOnConsole</key>
	<false/>
	<key>PushMagic</key>
	<string>B0F45E41-C0BB-4C57-9711-D7E087769982</string>
	<key>Token</key>
	<data>
	Zb1vFYLas0PZZDholg+jz6q5YH6sLYpFfUpw2ITXI6c=
	</data>
	<key>Topic</key>
	<string>com.apple.mgmt.External.04db860a-6ffa-4c12-bcac-e1be90a587ea</string>
	<key>UDID</key>
	<string>0A2B7C1D-0514-57C6-AD62-F72725D09C61</string>
	<key>UserID</key>
	<string>099C810D-B371-4729-8369-559BADA24F50</string>
	<key>UserLongName</key>
	<string>Corey</string>
	<key>UserShortName</key>
	<string>Corey</string>
</dict>
</plist>

Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
-------------------TokenUpdate start---------------
Device->Server TokenUpdate:
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>MessageType</key>
	<string>TokenUpdate</string>
	<key>NotOnConsole</key>
	<false/>
	<key>PushMagic</key>
	<string>B0F45E41-C0BB-4C57-9711-D7E087769982</string>
	<key>Token</key>
	<data>
	Zb1vFYLas0PZZDholg+jz6q5YH6sLYpFfUpw2ITXI6c=
	</data>
	<key>Topic</key>
	<string>com.apple.mgmt.External.04db860a-6ffa-4c12-bcac-e1be90a587ea</string>
	<key>UDID</key>
	<string>0A2B7C1D-0514-57C6-AD62-F72725D09C61</string>
	<key>UserID</key>
	<string>099C810D-B371-4729-8369-559BADA24F50</string>
	<key>UserLongName</key>
	<string>Corey</string>
	<key>UserShortName</key>
	<string>Corey</string>
</dict>
</plist>

-------------------Lock Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
-------------------getCode Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.email=?
-------------------getCode End---------------
-------------------Lock Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
出错了：null
-------------------Lock End---------------
-------------------ClearPasscode Start---------------
Hibernate: select mdm0_.id as id1_, mdm0_.control as control1_, mdm0_.createTime as createTime1_, mdm0_.deviceId as deviceId1_, mdm0_.email as email1_, mdm0_.pushMagic as pushMagic1_, mdm0_.pushToken as pushToken1_, mdm0_.token as token1_, mdm0_.topic as topic1_, mdm0_.udid as udid1_, mdm0_.unlockToken as unlockT11_1_ from db_mdm mdm0_ where mdm0_.deviceId=?
出错了：null
-------------------ClearPasscode End---------------
