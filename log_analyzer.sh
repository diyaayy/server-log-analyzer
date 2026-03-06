#!/bin/bash

echo "===== Log Analysis Report ====="

total=$(wc -l < server.log)
errors=$(grep -c "ERROR" server.log)
warnings=$(grep -c "WARNING" server.log)
info=$(grep -c "INFO" server.log)

echo "Total Logs: $total"
echo "ERROR: $errors"
echo "WARNING: $warnings"
echo "INFO: $info"