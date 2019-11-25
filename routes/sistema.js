var express = require('express');
var formidable = require('formidable')

var router = express.Router();

/* GET users listing. */
router.get('/', function(err, req, res, next) {
  return send.status(400).send('Método não permitido!');
});

/* POST users listing. */
router.post('/', function(req, res, next) {
  res.send('Olá Marilene...');


});

module.exports = router;
