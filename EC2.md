## Launching the flask app on an EC2 instance
- Create a new instance using ubuntu 20.04
- Add security groups to SSH and HTTP with port 5000 open to anywhere
- SSH into the EC2 instance
- Clone the git repository `git clone https://github.com/engineering89-final-project/jcpp.git` inside the instance
- Run `apt-get install python3-pip -y`
- Run `pip3 install -r requirements.txt` the requirements.txt file includes
```
flask
flask_wtf
passlib
requests
pandas
flask_table
list_function
lxml
```
- Navigate into the project folder `cd jccp`
- Run `export FLASK_APP=main.py`
- Run `python3 -m flask run --host=0.0.0.0`