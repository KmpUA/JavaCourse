<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        body {
            padding-top: 50px;
        }

        .error-container {
            text-align: center;
            padding: 50px;
        }

        h1 {
            font-size: 3rem;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.2rem;
            margin-bottom: 30px;
        }

        .btn-back {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1.2rem;
            text-decoration: none;
            border: 2px solid #333;
            color: #333;
            border-radius: 5px;
            transition: all 0.3s ease-in-out;
        }

        .btn-back:hover {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>

<body>

<!-- Error Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12 error-container">
            <h1>Oops! Something went wrong.</h1>
            <p>We're sorry, but there seems to be an error.</p>
            <a href="index.jsp" class="btn btn-back">Go Back to Home</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</script>
</body>

</html>
