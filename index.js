const express = require('express');
const bodyParser = require('body-parser');
const session = require('express-session');
const mysql = require('mysql');
const ejs = require('ejs');

const app = express();
const port = 3001;

app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(session({ secret: 'mysecretkey', resave: true, saveUninitialized: true }));

// Configuración de la base de datos
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'micarritodecompras',
});

db.connect((err) => {
  if (err) {
    console.error('Error al conectar a la base de datos:', err);
    throw err;
  }
  console.log('Conexión exitosa a la base de datos');
});

// Ruta para mostrar los zapatos
app.get('/zapatos', async (req, res) => {
  try {
    const results = await query('SELECT * FROM productos');
    res.render('zapatos', { zapatos: results });
  } catch (err) {
    console.error('Error al recuperar zapatos:', err);
    res.status(500).send('Error interno del servidor');
  }
});

// Función para ejecutar consultas SQL
function query(sql, args) {
  return new Promise((resolve, reject) => {
    db.query(sql, args, (err, results) => {
      if (err) return reject(err);
      resolve(results);
    });
  });
}

app.listen(port, () => {
  console.log(`Servidor http://localhost:${port}`);
});
