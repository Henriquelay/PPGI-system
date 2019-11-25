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

  form.on('fileBegin', function (name, file){
    file.path = __dirname + '/..' +'/uploads/' + file.name;
  });

  form.on('file', function (name, file){
      console.log('Uploaded ' + file.name);
  });

  return res.sendStatus(200, 'Enviado');

});

module.exports = router;
