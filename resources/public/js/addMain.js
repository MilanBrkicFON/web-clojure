function addNewMember() {
    $.confirm({
        title: 'Add new member',
        content: '<form action="/model/member/insert" method="post">' +
        '<div class="form-group">' +
        '<label>Identification number:</label>' +
        ' <input type="number" class="form-control" name="member_id" placeholder="Identification number">' +
        ' </div>' +
        '<div class="form-group">' +
        '<label>Member name</label>' +
        '<input type="text" class="form-control" name="name" placeholder="Member name">' +
        '</div>' +
        '<div class="form-group">' +
        '<label>Member last name</label>' +
        '<input type="text" class="form-control" name="surname" placeholder="Member last name">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Birthday</label>' +
        '<input type="date" class="form-control" name="birthday" placeholder="Birthday">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Sex</label>' +
        '<input type="text" class="form-control" name="sex" placeholder="Sex">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>City</label>' +
        '<input type="text" class="form-control" name="city" placeholder="City">' +
        '</div>' +
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add member</button>' +
        '</form>',

        cancel: function () {
        }
    });
}

function addNewCity() {
    $.confirm({
        title: 'Add new city',
        content: '<form action="/model/city/insert" method="post">' +
        '<div class="form-group">' +
        '<label>Name of the city</label>' +
        ' <input type="text" class="form-control" name="city_name" placeholder="Name of the city">' +
        ' </div>' +
        '<div class="form-group">' +
        '<label>Value of postal code</label>' +
        '<input type="number" class="form-control" name="postal_code" placeholder="Value of the postal code">' +
        '</div>' +
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add city</button>' +
        '</form>',

        cancel: function () {

        }
    });
}