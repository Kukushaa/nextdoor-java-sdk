#!/bin/bash

echo "Deploying with profile: skip-tests-deploy"

mvn clean deploy -Pskip-tests-deploy

echo "Deployed successfully"