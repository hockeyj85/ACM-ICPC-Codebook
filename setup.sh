#!/bin/bash

# Make sure python and pip are installed and up to date.
sudo apt-get upadate
sudo apt-get install python-pip python-dev build-essential
sudo pip-install --upgrade pip
sudo pip install -r notebook-gen/requirements.txt

