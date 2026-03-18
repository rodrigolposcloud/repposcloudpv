<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Punto de Venta | Acceso</title>

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        background: url("acceso/images/imagen01.jpg") no-repeat center center fixed;
        background-size: cover;
        font-family: Arial, Helvetica, sans-serif;
    }

    .login-container {
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background: rgba(0, 0, 0, 0.45);
    }

    .login-panel {
        background: #ffffff;
        padding: 30px;
        border-radius: 6px;
        width: 100%;
        max-width: 400px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.4);
    }

    .login-panel h3 {
        margin-bottom: 25px;
        text-align: center;
        color: #003471;
        font-weight: bold;
    }

    .btn-login {
        background-color: #003471;
        color: #fff;
        width: 100%;
    }

    .btn-login:hover {
        background-color: #002654;
        color: #fff;
    }

    footer {
        text-align: center;
        margin-top: 20px;
        font-size: 12px;
        color: #777;
    }
</style>

</head>

<body>

<div class="login-container">

    <form action="login" method="POST" class="login-panel">

        <h3>
            <span class="glyphicon glyphicon-lock"></span>
            Acceso al Sistema
        </h3>

        <div class="form-group">
            <label>Usuario</label>
            <input type="text" name="usuario" id="usuario"
                   class="form-control" placeholder="Usuario"
                   required autofocus>
        </div>

        <div class="form-group">
            <label>Contraseña</label>
            <input type="password" name="password" id="password"
                   class="form-control" placeholder="Contraseña"
                   required>
        </div>

 
        <button type="submit" class="btn btn-login">
            Ingresar
        </button>

        <footer>
            © 2026 – Sistema Punto de Venta<br>
            Desarrollado por RodrigoIA
        </footer>

    </form>

</div>

<!-- JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
