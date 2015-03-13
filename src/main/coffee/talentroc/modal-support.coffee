define ["jquery", "bootstrap/modal"], ($) ->
  getClientIdFromOptions = (options) ->
    "##{options.id}"

  large: (options) ->
    id = getClientIdFromOptions options

    if options.large
      $("#{id} .modal-dialog").addClass "modal-lg"
    else
      $("#{id} .modal-dialog").removeClass "modal-lg"
    return

  call: (options) ->
    modal = $ getClientIdFromOptions options
    modal.modal options.params
    return
