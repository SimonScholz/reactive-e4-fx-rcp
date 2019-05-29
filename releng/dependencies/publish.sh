#!/bin/bash
user=simon-scholz
token=8e0b2589bf865bb6aae0e59ba8a2ca7c3e1ce789
path=simon-scholz/eclipse-apps/re4fx/0.1.0/re4fx

curl -T ./build/updatesite.zip -u $user:$token -H "X-Bintray-Explode: 1" -H "X-Bintray-Package:re4fx" -H "X-Bintray-Version:0.1.0" https://api.bintray.com/content/$path
