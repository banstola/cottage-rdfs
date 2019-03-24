$(document).ready(function () {

    var app = {


        init: function () {

            $('#submit').click(app.submitListener)

        },
        submitListener: function (event) {

            event.preventDefault();

            var requestData = {
                numberOfPeople: $('#numberOfPeople').val(),
                numberOfBedRooms: $('#numberOfBedrooms').val(),
                distanceToLake: $('#distanceToLake').val(),
                distanceToNearestCity: $('#distanceToNearestCity').val(),
                cityName: $('#cityName').val(),
                dateOfArrival: $('#dateOfArrival').val(),
                durationOfStay: $('#durationOfStay').val(),
                shift: $('#shift').val(),
                bookerName: $('#bookerName').val()
            };

            app.makeRequest(requestData);
        },

        backendUrl: "/search",

        makeRequest: function (requestData) {

            $.get(app.backendUrl, requestData, function (response) {
                app.renderChanges(response);
            })


        },

        getBookingPeriod:function(response){

            return 12; // TODO make calculations
        },

        renderChanges: function (response) {


            $('#responsearea').children().remove();
           var div = $.each(response,function (index, data) {

                var individualCottage =  "<ul><li> Booker name" + data.name + "</li>" +
                    "<li>Booking number : " + data.id + "</li>" +
                    "<li>Address Of Cottage : " + data.addressString + "</li>" +
                    "<li>Cottage capacity : " + data.numberOfPeople + "</li>" +
                    "<li>Bedrooms : " + data.numberOfBedRooms + "</li>" +
                    "<li>Distance to Lake : " + data.distanceToLake + "</li>" +
                    "<li>Nearest city : " + data.cityName + "</li>" +
                    "<li>Distance to nearest city : " + data.distanceToNearestCity + "</li>" +
                    "<li>Booking period : " + app.getBookingPeriod(response) + "</li>"+
                    "<li><div> <img src=\"" + data.image + "\"> </div><ul/>"


               $('#responsearea').append(individualCottage);

            });



        }

    };

    app.init();

});