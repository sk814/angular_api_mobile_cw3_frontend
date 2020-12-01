var json=`{
	"course": {
		"name": {
			"_id": "CO3102",
			"__text": "Mobile and Webb app"
		},
		"teacher": {
			"name": "Y Hong",
			"_id": "srm13"
		},
		"student": [
			{
				"name": "Lisa Simpson",
				"cw1": "30",
				"project": "80",
				"final": "85",
				"_id": "ls1"
			},
			{
				"name": "Bart Simson",
				"cw1": "80",
				"project": "100",
				"final": "82",
				"_id": "bs1"
			},
			{
				"name": "Homer Simpson",
				"cw1": "60",
				"project": "50",
				"final": "90",
				"_id": "hs1"
			}
		]
	}
}`;
            
var obj=JSON.parse(json);

//1:
for(var m of obj.course.student){ console.log(m.name); }
//2:
for(var m of obj.course.student)
{ if(m.name=="Lisa Simpson"){ console.log(m.cw1); }
}

//2:
var avg=0;
var sum=0;
var count=0;
for(var m of obj.course.student){ 
sum+=parseFloat(m.project);
count++;
}
avg=sum/count;
console.log(avg)
