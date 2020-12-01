##MyCoVTestHub Project is developed using Pycharm IDE, Django (python3), sqlite3 and Grappelli framework for backend and HTML, CSS, JQuery, Bootstrap, AJAX and fontawesome in frontend and is running in localhost for now.

####DatabaseName: Shangri-La.sqlite3
***
###Credentials for dashboard
- ####**USERNAME**: sk814
- ####**PASSWORD**: 12345
***
---
##Steps to to run the project via terminal (Or can be imported/opened using IDE, for example pycharm)

- **Step1:** Go to the project directory(MyCoVTestHub) and check for python3 version(Install if not found).
    
        $ python3 -V
        Python 3.8.5

- **Step2:** django version (Install if not found).
        
        $ python3 -m django --version
        3.1.3

- **Step3:** Run django server 
        
        $ python3 manage.py runserver
        
        Watching for file changes with StatReloader
        Performing system checks...

        System check identified no issues (0 silenced).
        November 30, 2020 - 12:48:07
        Django version 3.1.3, using settings 'MyCoVTestHub.settings'
        Starting development server at http://127.0.0.1:8000/
        Quit the server with CONTROL-C.

- **Step4:** Open the url http://127.0.0.1:8000/ into the browser (Crome for example) and project will run.

- **Step5:** To login into the dashboard click admin button on the right upper corner and to check places
in map stored in Database click GoogleMapLocation button.
---
##Link for dashboard
Dashboard link: http://127.0.0.1:8000/admindashboard/login/?next=/admindashboard/MyCoVTestHubApplication/virustesting/

Map link: http://127.0.0.1:8000/admindashboard/login/?next=/admindashboard/MyCoVTestHubApplication/place/

######Thank You!