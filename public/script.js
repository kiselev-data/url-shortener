$( "#long2shortForm" ).submit(function( event ) {

  // Stop form from submitting normally
  event.preventDefault();

  // Get some values from elements on the page:
  var $form = $( this ),
    value = $form.find( "input[name='s']" ).val(),
    submit_url = $form.attr( "action" );

  // Send the data using post
  alert(value);
  var posting = $.post( submit_url, { url: value } );

  // Put the results in a div
  posting.done(function( data ) {
    alert(data);
    var content = $( data ).find( "#shortUrl" );
    #alert(content);
    $( "#result" ).empty().append( content );
  });
});