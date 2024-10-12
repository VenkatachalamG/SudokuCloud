<h1>Sudoku Solver with AWS Lambda</h1>
<p>This project is a cloud-based Sudoku solver deployed on AWS Lambda. The application processes Sudoku puzzles in JSON format and provides solutions, leveraging the power of AWS for seamless scalability.</p>

<h2>Features</h2>
<ul>
    <li><strong>Cloud Deployment:</strong> Deployed as an AWS Lambda function using a .jar file.</li>
    <li><strong>JSON Input Parsing:</strong> Accepts Sudoku boards in JSON format and validates input.</li>
    <li><strong>Lambda Function URL:</strong> Accessible via an authenticated Lambda URL for security.</li>
    <li><strong>Automatic Sudoku Solving:</strong> Utilizes a Java-based algorithm to solve the puzzle efficiently.</li>
    <li><strong>Scalable and Serverless:</strong> Runs entirely serverless, taking advantage of AWS Lambda's event-driven architecture.</li>
</ul>

<h2>Project Structure</h2>
<ul>
    <li><strong>CloudSudoku/</strong> - Contains the Lambda handler and the main application logic.</li>
    <li><strong>SudokuSolver.java</strong> - Implements the algorithm to solve Sudoku puzzles.</li>
    <li><strong>SudokuInput.java</strong> - A POJO class for parsing the input JSON payload.</li>
    <li><strong>pom.xml</strong> - Maven file managing dependencies like AWS Lambda and Jackson.</li>
</ul>

<h2>Getting Started</h2>
<h3>Prerequisites</h3>
<ul>
    <li>AWS account</li>
    <li>AWS CLI configured with proper credentials</li>
    <li>AWS IAM role with permissions for Lambda</li>
    <li>Java 11 or later</li>
    <li>Maven</li>
</ul>

<h3>Setup Instructions</h3>
<p>Clone the repository:</p>
<pre><code>git clone https://github.com/yourusername/sudoku-solver-lambda.git
cd sudoku-solver-lambda
</code></pre>

<p>Build the project:</p>
<pre><code>mvn clean package
</code></pre>
<p>This creates a .jar file in the <code>target/</code> directory.</p>

<h3>Deploy to AWS Lambda:</h3>
<ol>
    <li>Create a new Lambda function in the AWS Console and upload the .jar file generated.</li>
    <li>Set the handler to <code>CloudSudoku.LambdaHandler::handleRequest</code>.</li>
    <li>Assign the necessary IAM role to the Lambda function.</li>
</ol>

<h3>Configure Lambda Function URL:</h3>
<ul>
    <li>Enable a Lambda function URL and set the authorization type to AWS_IAM.</li>
    <li>Grant appropriate permissions to allow access.</li>
</ul>

<h3>Using the AWS CLI:</h3>
<p>To test the Lambda function using the AWS Command Line Interface, run the following command:</p>
<pre><code>aws lambda invoke \
    --function-name lambda-sudoku \
    --invocation-type RequestResponse \
    --cli-binary-format raw-in-base64-out \
    --payload '{"board": [[5,3,0,0,7,0,0,0,0], [6,0,0,1,9,5,0,0,0], [0,9,8,0,0,0,0,6,0], [8,0,0,0,6,0,0,0,3], [4,0,0,8,0,3,0,0,1], [7,0,0,0,2,0,0,0,6], [0,6,0,0,0,0,2,8,0], [0,0,0,4,1,9,0,0,5], [0,0,0,0,8,0,0,7,9]]}' \
    output.json
</code></pre>
<p>This command will invoke the Lambda function and store the response in <code>output.json</code>.</p>

<h3>Testing :</h3>
<p>You could test out your function in the AWS Console as shown below :</p>

![Testing AWS Console](https://github.com/user-attachments/assets/baafdf1f-45f2-4b05-a703-8b9d2cd6b7da)   ![Testing the function in AWS Console](https://github.com/user-attachments/assets/5503b2b7-9ce9-4e05-a66f-ef601392a3e1)

<strong><p>AWS Console Testing pics </p></strong>

<h3>Output</h3>

<p><h2>1.</h2>The tabular form of the out put in the AWS Console:</p> 

<pre>
<code>
5 3 4 | 6 7 8 | 9 1 2 
6 7 2 | 1 9 5 | 3 4 8 
1 9 8 | 3 4 2 | 5 6 7 
---------------------
8 5 9 | 7 6 1 | 4 2 3 
4 2 6 | 8 5 3 | 7 9 1 
7 1 3 | 9 2 4 | 8 5 6 
---------------------
9 6 1 | 5 3 7 | 2 8 4 
2 8 7 | 4 1 9 | 6 3 5 
3 4 5 | 2 8 6 | 1 7 9
</code>
</pre>

<p><h2>1.</h2>The output.json file:</p>

<pre>
<code>
cat output.json
"{\"result\": \"5 3 4 | 6 7 8 | 9 1 2 \\n6 7 2 | 1 9 5 | 3 4 8 \\n1 9 8 | 3 4 2 | 5 6 7 \\n---------------------\\n8 5 9 | 7 6 1 | 4 2 3 \\n4 2 6 | 8 5 3 | 7 9 1 \\n7 1 3 | 9 2 4 | 8 5 6 \\n---------------------\\n9 6 1 | 5 3 7 | 2 8 4 \\n2 8 7 | 4 1 9 | 6 3 5 \\n3 4 5 | 2 8 6 | 1 7 9 \\n\"}"
</code>
</pre>


<h2>Notes</h2>
<ul>
    <li>Ensure that the AWS IAM role associated with the Lambda function has necessary permissions.</li>
    <li>Test the function locally before deploying it to ensure compatibility and minimize errors.</li>
</ul>
