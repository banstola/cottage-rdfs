$(document).ready(function () {

    var app = {

        getBookingPeriod: function () {

            //MP
            var arrival = $('#dateOfArrival').val();
            var duration = parseInt($('#durationOfStay').val());

            var aday = parseInt(arrival.substring(0, 2));
            var amonth = parseInt(arrival.substring(3, 5));
            var ayear = parseInt(arrival.substring(6, 10));

            var eday, emonth, eyear;

            eday = aday + duration;
            emonth = amonth;
            eyear = ayear;

            //2.0.-24.0.201
            // Put everything to one string that is the returned
            return aday.toString() + "." + amonth.toString() + ".-" + eday.toString() + "." + emonth.toString() + "." + eyear.toString();
        },
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

        renderChanges: function (response) {


            $('#responsearea').children().remove();
            var div = $.each(response, function (index, data) {

                var individualCottage = "<ul><li> Booker name" + data.name + "</li>" +
                    "<li>Booking number : " + data.id + "</li>" +
                    "<li>Address Of Cottage : " + data.addressString + "</li>" +
                    "<li>Cottage capacity : " + data.numberOfPeople + "</li>" +
                    "<li>Bedrooms : " + data.numberOfBedRooms + "</li>" +
                    "<li>Distance to Lake : " + data.distanceToLake + "</li>" +
                    "<li>Nearest city : " + data.cityName + "</li>" +
                    "<li>Distance to nearest city : " + data.distanceToNearestCity + "</li>" +
                    "<li>Booking period : " + app.getBookingPeriod(response) + "</li>" +
                    "<li><div> <img src=\"" + data.image + "\"> </div><ul/>";


                $('#responsearea').append(individualCottage);

            });


        }

    };

    app.init();

});