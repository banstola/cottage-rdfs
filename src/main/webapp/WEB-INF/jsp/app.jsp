<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Cottage Booking Service</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="<c:url value="js/main.js"/>" type="text/javascript"></script>
  <link href="<c:url value="css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Welcome to cottage booking</h1>
<p>
  Please answer all of the boxes listed below.<br>
  If one answer is missing, you won't be able to get information about the available cottages.
</p>
<div id="formarea">
  <form id="bookingform">
    <fieldset id="fieldset1">
      <legend id="legend1">Booking details</legend>
      <div class="information">
        <label for="bookerName">
          Name of the booker
          <input required id="bookerName" type="text" minlength="2" size="40" value=""
                 placeholder=" E.g. John Smith " name="bookerName" />
        </label>
        <label for="numberOfPeople">
          Number of people staying in the cottage
          <input type="number" id="numberOfPeople" required min="1" max="18" name="numberOfPeople"/>
        </label>
        <label for="numberOfBedrooms">
          Number of bedrooms in the cottage
          <input type="number" id="numberOfBedrooms" required min="1" max="6" name="numberOfBedrooms"/>
        </label>
        <label for="distanceToLake">
          Distance to the lake in meters
          <input type="number" id="distanceToLake" required min="30" max="1000" name="distanceToLake"/>
        </label>
        <label for="cityName">
          Name of the nearest city
          <input required id="cityName" type="text" minlength="2" size="40" value=""
                 placeholder=" E.g. Jyväskylä " name="cityName"/>
        </label>
        <label for="distanceToNearestCity">
          Distance to the neareset city in kilometers
          <input type="number" id="distanceToNearestCity" required min="0.5" step="0.1" max="10" name="distanceToNearestCity"/>
        </label>
        <label for="dateOfArrival">
          Date of arrival
          <input required id="dateOfArrival" type="text" minLenght="10"
                 size="40" value="" name="dateOfArrival" placeholder="E.g. 25-02-2018"/>
        </label>
        <label for="durationOfStay">
          Duration of the stay
          <input type="number" id="durationOfStay" required min="1" max="21" name="durationOfStay"/>
        </label>
        <label for="shift">
          Flexibility of the arrival in days
          <input type="number" id="shift" required min="1" max="5" name="shift"/>
        </label>
      </div>
    </fieldset>
    <div id="button">
      <button id="submit">Submit</button>
    </div>
  </form>
</div>
<div id="responsearea"></div>

</body>

</html>