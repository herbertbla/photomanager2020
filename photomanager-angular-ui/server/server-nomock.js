// eslint-disable-next-line @typescript-eslint/no-var-requires
var express = require('express');
// eslint-disable-next-line @typescript-eslint/no-unsafe-call
var app = express();
var port = process.env.PORT || 3000;

// eslint-disable-next-line @typescript-eslint/no-unsafe-call
app.listen(port);

console.log('RESTful API server started on: ' + port);

// eslint-disable-next-line @typescript-eslint/no-unsafe-call
app.get('/at.gv.justiz.management.configserver/svpersonenbeziehungen-ui/local2', function(req, res) {
// eslint-disable-next-line @typescript-eslint/no-unsafe-call
  res.end(JSON.stringify({
    name: 'svpersonenbeziehungen-ui',
    profiles: [
      'local2'
    ],
    label: null,
    version: 'cbd9413ce7c80e471bd17a77345f444a461418a4',
    state: null,
    propertySources: [
      {
        source: {
          'ods.url': 'http://localhost:8000/at.gv.justiz.local2.ods/',
          'ods.url.external': 'http://localhost:8000/at.gv.justiz.local2.ods/',
          'aktensystem.url': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-ui.url': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-ui.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem/',
          'aktensystem-pdf.url.external': 'http://localhost:8000/at.gv.justiz.local2.aktensystem-pdf/',
          'svpersonenbeziehungen-ui.url': 'http://localhost:8000/at.gv.justiz.local2.svpersonenbeziehungen/',
          'svpersonenbeziehungen-ui.url.external': 'http://localhost:8000/at.gv.justiz.local2.svpersonenbeziehungen/',
          'eingabesystem.url': 'http://localhost:8000/at.gv.justiz.local2.eingabesystem/',
          'eingabesystem.url.external': 'http://localhost:8000/at.gv.justiz.local2.eingabesystem/',
          'rore.url': 'http://localhost:8000/at.gv.justiz.local2.rore/',
          'rore.url.external': 'http://localhost:8000/at.gv.justiz.local2.rore/',
          'kalender.url': 'http://localhost:8000/at.gv.justiz.local2.kalender/',
          'kalender.url.external': 'http://localhost:8000/at.gv.justiz.local2.kalender/',
          'workflow.url': 'http://localhost:8000/at.gv.justiz.local2.workflow/',
          'workflow.url.external': 'http://localhost:8000/at.gv.justiz.local2.workflow/',
          'anwenderinfo.url': 'http://localhost:8000/at.gv.justiz.local2.anwenderinfo/',
          'anwenderinfo.url.external': 'http://localhost:8000/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass-0': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'anwenderinfo.url.bypass-1': 'http://localhost:8181/at.gv.justiz.local2.anwenderinfo-core/',
          'ztc.url.external': 'http://localhost:8000/at.gv.justiz.local2.ztc-core/',
          'uss.url.external': 'http://localhost:8000/at.gv.justiz.local2.ussservice/',
          'vws.url': 'http://localhost:8000/at.gv.justiz.local2.vws/',
          'vws.url.external': 'http://localhost:8000/at.gv.justiz.local2.vws/',
          'vws-cli.url': 'http://localhost:8000/at.gv.justiz.local2.vws-cli/',
          'vws-cli.url.external': 'http://localhost:8000/at.gv.justiz.local2.vws-cli/',
          'jufi.url.external': 'http://localhost:8000/at.gv.justiz.local2.jufi/',
            'jufi.online' : true,
          'zipkin.enabled': 'true',
          'zipkin.server.url': 'http://localhost:9411',
          'zipkin.logtoconsole': 'false',
          'zipkin.sampler.random': '1',
          'zipkin.sampler.counting': 'null'
        }
      }
    ]
  }));
});
