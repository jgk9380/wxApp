     $(function () {
          $('#velometer').speedometer();
          $('#testSpeed').click(function () {
              $('#velometer').speedometer( {
                  percentage : 50
              });
          });
      });