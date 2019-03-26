$(document).ready(function () {

    var app = {

        getBookingPeriod: function () {

            //MP
            var arrival = $('#dateOfArrival').val();
            var duration = $('#durationOfStay').val();

            var aday = parseInt(arrival.substring(0, 1));
            var amonth = parseInt(arrival.substring(3, 4));
            var ayear = parseInt(arrival.substring(6, 9));

            var eday, emonth, eyear;

            //  Check if the month has more than 28 days and the month is february
            if (aday + duration > 28 && amonth === 2) {
                eday = aday + duration - 28;
                emonth = amonth + 1;
            }

            //  Check if the month has more than 30 days and the months maximum number of days is 30
            if (aday + duration > 30 && (amonth === 3 || amonth === 6 || amonth === 9 || amonth === 11)) {
                eday = aday + duration - 30;
                emonth = amonth + 1;
            }

            //  Check if the month has more than 31 days and the month is december
            if (aday + duration > 31 && amonth === 12) {
                eday = aday + duration - 31;
                emonth = 1;
                eyear = ayear + 1;
            }

            //  Check if the month has more than 31 days and the month is not december and has maximum of 31 days
            if (aday + duration > 31 && (amonth === 3 || amonth === 5 || amonth === 7 || amonth === 8 || amont === 10)) {
                eday = aday + duration - 31;
                emonth = amonth;
                eyear = ayear;
            }
            // All of the so called normal cases
            elseif
            {
                eday = aday + duration;
                emonth = amonth;
                eyear = ayear;
            }

            // Put everything to one string that is the returned
            return aday.toString() + "." + amonth.toString() + ".-" + eday.toString() + "." + emonth.toString() + "." + eyear.toSring();
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