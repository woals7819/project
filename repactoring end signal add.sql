CREATE DATABASE Signal;

----------------DB--------------------
CREATE DATABASE SignalManagement;
DROP DATABASE SignalManagement;
DROP TABLE NomalSignal;
DROP TABLE CalculationSignal;
DROP TABLE CountSignal;

CREATE SEQUENCE Seq_Signal START 1;

DROP TABLE AllSignal;
TRUNCATE TABLE AllSignal;
SELECT * FROM AllSignal;
ALTER SEQUENCE Seq_Signal RESTART WITH 1;

---------------전체 신호----------------
CREATE TABLE AllSignal(
	TagNumber integer DEFAULT NEXTVAL('Seq_Signal') PRIMARY key,
	Signal VARCHAR(20) NOT NULL ,
	EquipmentName VARCHAR(50) NOT NULL,
	Tagname VARCHAR(30) NOT NULL DEFAULT '',
	SigName VARCHAR(30) NOT NULL DEFAULT '',
	Description TEXT NOT NULL ,
	SigType VARCHAR(20) NOT NULL DEFAULT '',
	EngLow INT NOT NULL DEFAULT 0,
	EngHigh INT NOT NULL DEFAULT 0,
	Unit VARCHAR(20) NOT NULL,
	Alarm VARCHAR(20) NOT NULL,
	StayTime INT NOT NULL DEFAULT 0,
	LL INT NOT NULL DEFAULT 0,
	L INT NOT NULL,
	H INT NOT NULL,
	HH INT NOT NULL DEFAULT 0,
	DI INT NOT NULL DEFAULT 0
);


---------------일반 신호----------------
CREATE TABLE NomalSignal(
	TagNumber SERIAL PRIMARY KEY,
	Signal VARCHAR(20) NOT NULL,
	EquipmentName VARCHAR(50) NOT NULL,
	TagName VARCHAR(50) NOT NULL,
	SigName VARCHAR(50) NOT NULL,
	Description TEXT NOT NULL,
	SigType VARCHAR(20) NOT NULL,
	EngLow INT NOT NULL,
	EngHigh INT NOT NULL,
	Unit VARCHAR(20) NOT NULL,
	Alarm VARCHAR(20) NOT NULL,
	StayTime INT NOT NULL,
	LL INT NOT NULL,
	L INT NOT NULL,
	H INT NOT NULL,
	HH INT NOT NULL,
	DI INT NOT NULL,
	SourceTagName VARCHAR(50) NOT NULL,
	SignalBit INT NOT NULL,
	DecimalPoint INT NOT NULL
);

SELECT * FROM NomalSignal;


---------------일반 신호 데이터----------------
INSERT INTO Nomalsignal
(Signal, EquipmentName, TagName, SigName, Description, SigType, EngLow, EngHigh,
Unit, Alarm, StayTime, LL, L, H, HH, DI, SourceTagName, SignalBit, DecimalPoint)
VALUES('일반','DOKJGHW', 'GSWKGW', 'DSOGLJ', 'FSDVNDSAWF', 'FDSFN', 0, 1, 'FVDF', 'BTY', 0, 1,0,1,2,1,'BJNER', 0, 1);

INSERT INTO Nomalsignal
(Signal,EquipmentName, TagName, SigName, Description, SigType, EngLow, EngHigh,
Unit, Alarm, StayTime, LL, L, H, HH, DI, SourceTagName, SignalBit, DecimalPoint)
VALUES('일반','ERGNDG', 'QPKDF', 'VRMDSCOV', 'DVCOWEM', 'XQLFM', 6, 2, 'WEMDXP', 'XMRDS', 6, 4,1,0,1,0,'DVMJWW', 5, 4);

INSERT INTO Nomalsignal
(Signal,EquipmentName, TagName, SigName, Description, SigType, EngLow, EngHigh,
Unit, Alarm, StayTime, LL, L, H, HH, DI, SourceTagName, SignalBit, DecimalPoint)
VALUES('일반','RGNSDV', 'XMMRE', 'XIEMF', 'XCOEMDS', 'RMVIS', 3, 6, 'FDGHSF', 'XMCEO', 5, 1,8,6,2,0,'GKEG', 4, 1);

INSERT INTO Nomalsignal
(Signal,EquipmentName, TagName, SigName, Description, SigType, EngLow, EngHigh,
Unit, Alarm, StayTime, LL, L, H, HH, DI, SourceTagName, SignalBit, DecimalPoint)
VALUES('일반','FKYDFFBGHW', 'GSJHL', 'ASXCRY', 'FGHJGHJDSAWF', 'FDUJL', 1, 8, 'HJU', 'AG', 3, 0,1,8,6,5,'ADSVGADF', 7, 5);

INSERT INTO Nomalsignal
(Signal,EquipmentName, TagName, SigName, Description, SigType, EngLow, EngHigh,
Unit, Alarm, StayTime, LL, L, H, HH, DI, SourceTagName, SignalBit, DecimalPoint)
VALUES('일반','FGHWERR', 'DFGHJYJ', 'DGHJLKSLJ', 'FGKSDGN', 'FHJMTRES', 1, 0, 'GDSW', 'MTRHJ', 1, 0,1,0,3,0,'AEHJTREJ', 1, 0);

---------------MES 신호----------------
CREATE TABLE Mes_Signal(
	TagNumber SERIAL PRIMARY KEY,
	TagName varchar(100) NOT NULL,
	Description varchar(200) NOT NULL,
	SigType varchar(40) NOT NULL,
	Treegroupidx int4  NOT NULL,
	IsDeleted bool DEFAULT 'false',
	IsUpdated bool DEFAULT 'false',
	View_Decimalpoint int4  DEFAULT 0 ,
	FleldName varchar(60)
);
SELECT * FROM Mes_Signal;
---------------MES 신호 데이터----------------
INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_ksldgnj', 'dlfnmgewg', 'DFBDFFBFD', 4, 1, 'DVGEWMVO');


INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_tyefdgnbnj', 'NMMMMMMM', 'dfxfgnxd', 4, 1, 'FGMJFGNRNY');

INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_TYCV', 'DSDDDDDDD', 'QMRTXIDS', 4, 1, 'WSDzxaCIOL');

INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_YY', 'QOTXCHDDF', 'DFOJKHJK', 4, 1, 'WEXCUJMTRFB');

INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_AEWRX', 'dUIGVKY', 'DFGCVXFD', 4, 1, 'QWZXILTF');

INSERT INTO mes_signal
(TagName, Description, SigType, Treegroupidx, View_Decimalpoint, FleldName)
VALUES('MES_ksldgnj', 'dlfnmgewg', 'DFBDFFBFD', 4, 1, 'DVGEWMVO');



---------------계산 신호----------------
CREATE TABLE CalculationSignal(
	TagNumber SERIAL PRIMARY KEY,
	Signal VARCHAR(20) NOT NULL,
	EquipmentName VARCHAR(50) NOT NULL,
	CalcTagName VARCHAR(50) NOT NULL,
	Description TEXT NOT NULL,
	Calculation VARCHAR(50) NOT NULL,
	EngLow INT NOT NULL,
	EngHigh INT NOT NULL,
	Unit VARCHAR(20) NOT NULL,
	Alarm VARCHAR(20) NOT NULL,
	L INT NOT NULL,
	H INT NOT NULL,
	DecimalPoint INT NOT NULL
);


---------------계산 신호 데이터----------------
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','ASDFDS', 'SGHDGWS', 'SADFJFKSIAF', 'SDGSVSDVE', 0, 0, 'ASD', '#', 0, 1, 0);
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','ATYTHRS', 'QGDFJH', 'TYNUWETB', 'rynertw', 0, 0, 'dnht', '=', 0, 1, 0);
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','AQMZXS', 'GHMTYM', 'ETCX', 'UKWS', 0, 0, 'UFV', '%', 0, 1, 0);
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','BQWED', 'TYJSZD', 'TASFSA', 'MTFUX', 0, 0, 'RGHS', '>', 0, 1, 0);
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','TYDSZAF', 'GM_DHDE', 'REYZXZXVC', 'YSDGCVN', 0, 0, 'EWSAD', '<', 0, 1, 0);
INSERT INTO CalculationSignal
(Signal,EquipmentName, CalcTagName, Description, Calculation, EngLow, EngHigh, Unit, Alarm,L, H,DecimalPoint)
VALUES('계산','IOLVCBX', 'YLSWEDRX', 'EWTTEUVN', 'MUJUGHN', 0, 0, 'KYDFVBH', '&', 0, 1, 0);

SELECT * FROM CalculationSignal;


---------------카운트 신호----------------
CREATE TABLE CountSignal(
	TagNumber SERIAL PRIMARY KEY,
	Signal VARCHAR(20) NOT NULL,
	EquipmentName VARCHAR(50) NOT NULL,
	CountTagName VARCHAR(50) NOT NULL,
	Description TEXT NOT NULL,
	L INT NOT NULL,
	H INT NOT NULL,
	Alarm VARCHAR(20) NOT NULL,
	Unit VARCHAR(20) NOT NULL,
	ConditionTag1 VARCHAR(20) NOT NULL,
	Condition1 VARCHAR(20) NOT NULL,
	Value1 INT NOT NULL,
	ConditionTag2 VARCHAR(20) NOT NULL,
	Condition2 VARCHAR(20) NOT NULL,
	Value2 INT NOT NULL,
	ConditionTag3 VARCHAR(20) NOT NULL,
	Condition3 VARCHAR(20) NOT NULL,
	Value3 INT NOT NULL,
	ConditionTag4 VARCHAR(20) NOT NULL,
	Condition4 VARCHAR(20) NOT NULL,
	Value4 INT NOT NULL,
	ConditionTag5 VARCHAR(20) NOT NULL,
	Condition5 VARCHAR(20) NOT NULL,
	Value5 INT NOT NULL,
	DecimalPoint INT NOT NULL
);

SELECT * FROM CountSignal;


---------------카운트 신호 데이터----------------
INSERT INTO CountSignal
(Signal,EquipmentName, CountTagName, Description, L, H, Alarm, Unit, ConditionTag1, Condition1, Value1,
ConditionTag2, Condition2, Value2, ConditionTag3, Condition3, Value3, ConditionTag4, Condition4, Value4,
ConditionTag5, Condition5, Value5, DecimalPoint)
VALUES('카운트','GDFSGW', 'BGWRR', 'DHEROGLK', 0, 0, 'DFGDFB', '%', 'GBDEGF', 'ANDFB', 0, 'YUKSDE',
'ANDFB', 1, 'LKTREG', 'RYNSD', 2, 'RTNYSX', 'RTHB', 3, 'DVSW', 'SVWV', 4, 0);

INSERT INTO CountSignal
(Signal,EquipmentName, CountTagName, Description, L, H, Alarm, Unit, ConditionTag1, Condition1, Value1,
ConditionTag2, Condition2, Value2, ConditionTag3, Condition3, Value3, ConditionTag4, Condition4, Value4,
ConditionTag5, Condition5, Value5, DecimalPoint)
VALUES('카운트','GadehehW', 'EWNDSVC', 'DVSJEM', 0, 0, 'XZEWM', '%!', 'GBEERSDF', 'QLKXP', 0, 'ETRNXP',
'TMDSC', 1, 'RNS', 'RMCX', 2, 'CUENM', 'REOF', 3, 'KDSXO', 'TSD', 4, 0);

INSERT INTO CountSignal
(Signal,EquipmentName, CountTagName, Description, L, H, Alarm, Unit, ConditionTag1, Condition1, Value1,
ConditionTag2, Condition2, Value2, ConditionTag3, Condition3, Value3, ConditionTag4, Condition4, Value4,
ConditionTag5, Condition5, Value5, DecimalPoint)
VALUES('카운트','RMCO', 'DMEAS', 'REMXO', 0, 0, 'ZEMS', '!', 'CXFEN', 'XMW', 0, 'CMEQ',
'REMDF', 1, 'XUIWEM', 'REMKC', 2, 'QMXPS', 'XKEWM', 3, 'RCPS', 'CZXB', 4, 0);

INSERT INTO CountSignal
(Signal,EquipmentName, CountTagName, Description, L, H, Alarm, Unit, ConditionTag1, Condition1, Value1,
ConditionTag2, Condition2, Value2, ConditionTag3, Condition3, Value3, ConditionTag4, Condition4, Value4,
ConditionTag5, Condition5, Value5, DecimalPoint)
VALUES('카운트','CNMWES', 'XQZA', 'REMSD', 0, 0, 'YMNIK', ' ', 'HMCVO', 'QXPA', 0, 'RMCOV',
'RASX', 1, 'ERSZF', 'CMEOD', 2, 'REMXA', 'ERMC', 3, 'REMXA', 'REMSPA', 4, 0);

INSERT INTO CountSignal
(Signal,EquipmentName, CountTagName, Description, L, H, Alarm, Unit, ConditionTag1, Condition1, Value1,
ConditionTag2, Condition2, Value2, ConditionTag3, Condition3, Value3, ConditionTag4, Condition4, Value4,
ConditionTag5, Condition5, Value5, DecimalPoint)
VALUES('카운트','SRCOSW', 'SDVBF', 'DCXFIWM', 0, 0, 'REDS', '%', 'RMCOE', 'ERFCOLS', 0, 'TRMDPS',
'ERMSDDGP', 1, 'RMTRWOPD', 'RSGJWRE', 2, 'RMWPDG', 'RMSPSAF', 3, 'MROSF', 'RTARD', 4, 0);


-- NS.Signal, CCS.Signal,NS.EquipmentName,CCS.EquipmentName, NS.TagName, NS.SigName, NS.Description, CCS.Description,
--NS.SigType, NS.EngLow, CCS.EngLow, NS.EngHigh, CCS.EngHigh, NS.Unit, CCS.Unit, NS.Alarm, CCS.Alarm, NS.StayTime,
--NS.LL, NS.L, CCS.L, NS.H, CCS.H, NS.HH, NS.DI 

SELECT sum(*) FROM CalculationSignal AS cu
INNER JOIN NomalSignal AS n
ON NS.tagnumber = CCS.tagnumber;

SELECT TagNumber,Signal FROM NomalSignal
UNION
SELECT TagNumber,Signal FROM CalculationSignal;


SELECT COUNT(*) FROM NomalSignal;
SELECT COUNT(*) FROM CalculationSignal;

SELECT a.n, b.u
FROM (SELECT COUNT(*) n FROM NomalSignal) as a , 
	 (SELECT COUNT(*) u FROM CalculationSignal) as b;



SELECT n.signal, n.EquipmentName, n.tagname, n.signame, n.description, n.sigtype, n.englow, n.enghigh,
n.unit, n.alarm, n.staytime, n.ll, n.l, n.h, n.hh, n.di, u.signal, u.description, u.englow, u.enghigh, u.unit,
u.l, u.h, u.alarm, c.EquipmentName, c.signal, c.description, c.l, c.h, c.alarm, c.unit
FROM CalculationSignal as u
RIGHT JOIN NomalSignal as n
ON n.tagnumber = u.tagnumber
RIGHT JOIN CountSignal as c
ON u.tagnumber = c.tagnumber;




------------------------------AllSignal에 다른 테이블 값 넣기--------------------------------------------------

INSERT INTO AllSignal (signal, EquipmentName, tagname, signame, description, sigtype, englow, enghigh,
unit, alarm, staytime, ll, l, h, hh, di)
SELECT signal, EquipmentName, tagname, signame, description, sigtype, englow, enghigh,
unit, alarm, staytime, ll, l, h, hh, di
FROM NomalSignal;


INSERT INTO AllSignal (tagname, signal, EquipmentName, description, englow, enghigh,
unit, alarm, l, h)
SELECT (CalcTagName)AS tagname,signal, EquipmentName, description, englow, enghigh,
unit, alarm, l, h
FROM CalculationSignal;


INSERT INTO AllSignal (tagname, signal, EquipmentName, description, unit, alarm, l, h)
SELECT (CountTagName)AS tagname, signal, EquipmentName, description, unit, alarm, l, h
FROM CountSignal;

SELECT * FROM AllSignal;




select count(*) from AllSignal;
ALTER SEQUENCE Signal RESTART WITH 1;
select setval('Seq_Signal',1,false);

SHOW search_path;

ALTER USER postgres SET SEARCH_path='Signal';

search_path;


DELETE FROM AllSignal;


select count(*) from CalculationSignal u
INNER JOIN NomalSignal n
ON u.tagnumber = n.tagnumber
where t.tagname LIKE upper('%"+word+"%') AND t2.tagdescription like upper('%"+word+"%');



select count(*) from CalculationSignal u
INNER JOIN NomalSignal n
ON u.tagnumber = n.tagnumber
GROUP BY tagnumber;

SELECT COUNT(*) FROM allsignal
WHERE upper() LIKE upper('%%') AND 
SELECT (Select Count(*) from CalculationSignal ) + (Select Count(*) from NomalSignal)+(Select Count(*) from CountSignal) as Total;

----------------------------------------All 검색 Count--------------------------------------------------------
SELECT(
(Select Count(*) from NomalSignal
WHERE upper(SigName) like UPPER('%s%') OR upper(Signal) like UPPER('%s%') OR upper(EquipmentName) like UPPER('%s%') OR
upper(TagName) like UPPER('%s%') OR upper(Description) like UPPER('%s%') OR upper(SigType) like UPPER('%s%') OR 
upper(Unit) like UPPER('%s%') OR upper(Alarm) like UPPER('%s%'))
+
(Select Count(*) from CalculationSignal
WHERE upper(EquipmentName) like UPPER('%s%') OR upper(Signal) like UPPER('%s%') OR upper(CalcTagName) like UPPER('%s%') OR
upper(Description) like UPPER('%s%') OR upper(Calculation) like UPPER('%s%') OR upper(Unit) like UPPER('%s%') OR 
upper(Alarm) like UPPER('%s%'))
+
(Select Count(*) from CountSignal
WHERE upper(Signal) like UPPER('%s%') OR upper(EquipmentName) like UPPER('%s%') OR upper(CountTagName) like UPPER('%s%') OR
upper(Description) like UPPER('%s%') OR upper(Alarm) like UPPER('%s%') OR upper(Unit) like UPPER('%s%') OR 
upper(ConditionTag1) like UPPER('%s%') OR upper(Condition1) like UPPER('%s%')OR upper(ConditionTag2) like UPPER('%s%') OR
upper(Condition2) like UPPER('%s%')OR upper(ConditionTag3) like UPPER('%s%') OR upper(Condition3) like UPPER('%s%')
OR upper(ConditionTag4) like UPPER('%s%') OR upper(Condition4) like UPPER('%s%')OR upper(ConditionTag5) like UPPER('%s%') OR upper(Condition5) like UPPER('%s%')))
AS Total;


SELECT count(*) FROM allsignal
WHERE upper(Signal) LIKE upper('%s%') AND upper(EquipmentName) LIKE upper('%s%') AND
upper(Tagname) LIKE upper('%s%') AND upper(SigName) LIKE upper('%s%') AND
upper(Description) LIKE upper('%s%') AND upper(SigType) LIKE upper('%s%') AND
upper(Unit) LIKE upper('%s%') AND upper(Alarm) LIKE upper('%%');
Signal || EquipmentName || Tagname || SigName || Description 
|| SigType || Unit || Alarm


----------------------------------------전제 조회 All 검색 Count--------------------------------------------------------
SELECT count(*) FROM AllSignal where upper((Signal || EquipmentName || Tagname || SigName || Description
|| SigType || Unit || Alarm)) like upper('%s%');
----------------------------------------전제 조회 col 검색 Count--------------------------------------------------------
SELECT count(*) FROM allsignal
WHERE upper(EquipmentName) LIKE upper('%g%');


----------------------------------------전제 조회 All 검색 list--------------------------------------------------------
SELECT * FROM AllSignal where upper((Signal || EquipmentName || Tagname || SigName || Description 
|| SigType || Unit || Alarm)) like upper('%s%') IS NOT NULL;
------------------------------일반까지만 나옴----------------------------------------------------------------------------
				
				

				
SELECT * FROM AllSignal WHERE upper("+ col +") LIKE upper('%"+word+"%');




Select * from NomalSignal;





select count(*) from NomalSignal;



select * from (select ROW_NUMBER() OVER(order by TagNumber) as rn,tagnumber, signal, Equipmentname, tagname, signame,
description, sigtype, englow, enghigh, unit, alarm, staytime, ll,l,h,hh,di from
(select * from AllSignal where upper((Signal || EquipmentName || Tagname || SigName || Description 
|| SigType || Unit || Alarm)) like upper('%s%') order by TagNumber) as a) as b where rn between 1 and 80;



SELECT a.TagName, m.TagName FROM allsignal a
INNER JOIN mes_signal m
ON a.tagnumber = m.tagnumber;


















