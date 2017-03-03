
The Objective is that we should be able to group each column of all rows, and each column value(content) could be json as shown below.

here is the CSV file example:



a,f,w,b,numinst,af,ub
1CL,2cl,64,22,1,48:2,true
1CL,"2cl",16,39,1,48:2,true
"1CL","{'2cl':'76','second':435}","640",330,1,48:2,true
1CL,800,40,124,1,48:2,true
1CL,900,"{'3cl':'76','third':435}",104,1,48:2,true
'1CL',800,8,104,"{'jsonTesting':'jhsgdf','working':'withsingle quotes','json':'shall be in singlequotes'}",48:2,true
"1cl","vishu",65536,39,1,"{'6cl':'76','sixth':435}",true
"{'myjson':'762354','first':76234}",800,2048,39,1,96:96,false
1R1W,800,8192,39,1,48:48,"{'lastCL':'ert','test':9945}"



The highlighted are the json values of respective rows.


My program will read this file and gives you column groups as shown below , now they are printed at console but you can have it to any data structure you wanted.
I have commented the code appropriately.

I have used commons-csv-1.4.jar library to get CSVRecord class.



Output :-

CSV records :{0=[a, f, w, b, numinst, af, ub], 1=[1CL, 2cl, 64, 22, 1, 48:2, true], 2=[1CL, 2cl, 16, 39, 1, 48:2, true], 3=[1CL, {'2cl':'76','second':435}, 640, 330, 1, 48:2, true], 4=[1CL, 800, 40, 124, 1, 48:2, true], 5=[1CL, 900, {'3cl':'76','third':435}, 104, 1, 48:2, true], 6=['1CL', 800, 8, 104, {'jsonTesting':'jhsgdf','working':'withsingle quotes','json':'shall be in singlequotes'}, 48:2, true], 7=[1cl, vishu, 65536, 39, 1, {'6cl':'76','sixth':435}, true], 8=[{'myjson':'762354','first':76234}, 800, 2048, 39, 1, 96:96, false], 9=[1R1W, 800, 8192, 39, 1, 48:48, {'lastCL':'ert','test':9945}]}
Column Groups
a
1CL
1CL
1CL
1CL
1CL
'1CL'
1cl
{'myjson':'762354','first':76234}
1R1W
==============================================
f
2cl
2cl
{'2cl':'76','second':435}
800
900
800
vishu
800
800
==============================================
w
64
16
640
40
{'3cl':'76','third':435}
8
65536
2048
8192
==============================================
b
22
39
330
124
104
104
39
39
39
==============================================
numinst
1
1
1
1
1
{'jsonTesting':'jhsgdf','working':'withsingle quotes','json':'shall be in singlequotes'}
1
1
1
==============================================
af
48:2
48:2
48:2
48:2
48:2
48:2
{'6cl':'76','sixth':435}
96:96
48:48
==============================================







Each column separated by =================== line.