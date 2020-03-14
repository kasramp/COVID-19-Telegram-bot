#!/bin/bash

curl -d "{\"url\": \"$URL/v1/$TOKEN\"}" -H "Content-Type: application/json" -X POST "https://api.telegram.org/bot$TOKEN/setWebhook" 
