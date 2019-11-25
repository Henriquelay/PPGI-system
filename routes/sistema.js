var express = require('express');
var formidable = require('formidable')

var router = express.Router();

/* GET users listing. */
router.get('/', function(err, req, res, next) {
  return send.status(400).send('Método não permitido!');
});

/* POST users listing. */
router.post('/', function(req, res, next) {
  var form = new formidable.IncomingForm();

  form.parse(req);
  var nomesvalidos = ['veiculos.csv', 'docentes.csv', 'regras.csv', 'qualis.csv', 'publicacoes.csv'];
  form.on('fileBegin', function (name, file) {
    var contem = false;
    // Checa se o nome está correto
    for(var i = 0; i < nomesvalidos.length; i++) {
      if(nomesvalidos[i] == file.name)
        contem = true;
    }
    if(contem) {
      file.path = __dirname + '/..' +'/uploads/' + file.name;
      console.log('Arquivo movido. \'' + file.name + '\' é um nome VÁLIDO.');
    } else {
      console.log('Arquivo \'' + file.name + '\' é um nome INVÁLIDO.');
    }
  });

  form.on('file', function (name, file) {
      console.log('Arquivo processado ' + file.name);
  });

  var ano;
  form.on('field', function(name, field) {
    ano = field;
    console.log('Campo ' + ano);
  });

  return res.sendStatus(200, 'Enviado');

});

module.exports = router;
