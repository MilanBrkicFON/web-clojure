function addNewMember(){
    $.confirm({
        title: 'Add new member',
        content: '<form action="/model/member/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Identification number:</label>'+
        ' <input type="number" class="form-control" name="identification_number" placeholder="Identification number">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>Member name</label>' +
        '<input type="text" class="form-control" name="member_name" placeholder="Member name">' +
        '</div>' +
        '<div class="form-group">'+
        '<label>Member last name</label>' +
        '<input type="text" class="form-control" name="member_lastname" placeholder="Member last name">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Birthday</label>' +
        '<input type="date" class="form-control" name="birthday" placeholder="Birthday">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>Sex</label>' +
        '<input type="text" class="form-control" name="sex" placeholder="Sex">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>City</label>' +
        '<input type="text" class="form-control" name="city" placeholder="City">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add member</button>' +
        '</form>',

        cancel: function(){}
    });
}

function addNewInterest() {
    $.confirm({
        title: 'Add new interest',
        content: '<form action="/domain/interests/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Name of the bank</label>'+
        ' <input type="text" class="form-control" name="name" placeholder="Name of the bank">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>Value of the interest</label>' +
        '<input type="text" class="form-control" name="value" placeholder="Value of the interest">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Type of interest</label>' +
        '<input type="number" class="form-control" name="id_typeinterest" placeholder="Type of interest id" id="id_typeinterest">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add interest</button>' +
        '<label>ATTENTION: Type of interest can only be from range 1-3! </label>'+
        '</form>',

        cancel: function(){

        }
    });
}