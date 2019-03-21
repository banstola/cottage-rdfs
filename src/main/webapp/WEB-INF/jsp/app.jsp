<!DOCTYPE html>
<html lang="en">
<head>
  <title>Book a cottage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>

<div class="container">
  <h2></h2>
  <form action="/action_page.php">
    <div class="form-group">
      <label for="booker-name">Enter your name</label>
      <input type="text" class="form-control" id="booker-name" placeholder="Enter your name" name="booker-name">
    </div>
    <div class="form-group">
      <label for="number-of-people">Number of People</label>
      <input type="number" class="form-control" id="number-of-people" placeholder="Number of people" name="number-of-people">
    </div>


    <div class="form-group">
      <label for="number-of-bedrooms">Number of Bedrooms</label>
      <input type="number" class="form-control" id="number-of-bedrooms" placeholder="Number of people" name="number-of-bedrooms">
    </div>

    <div class="form-group">
      <label for="distance-from-lake">Distance from Lake</label>
      <input type="number" class="form-control" id="distance-from-lake" placeholder="Distance to lake (in meters)" name="distance-from-lake">
    </div>

    <div class="form-group">
      <label for="nearest-city-name">Name of nearest city</label>
      <input type="text" class="form-control" id="nearest-city-name" placeholder="Enter the nearest city" name="nearest-city-name">
    </div>


    <div class="form-group">
      <label for="distance-to-city">Distance to city</label>
      <input type="number" class="form-control" id="distance-to-city" placeholder="Distance to city (in kilometers)" name="distance-to-city">
    </div>


    <div class="form-group">
      <label for="arrival-date">Arrival date</label>
      <input type="datetime-local" class="form-control" id="arrival-date" placeholder="Arrival date" name="arrival-date">
    </div>

    <div class="form-group">
      <label for="duration">Duration (in days)</label>
      <input type="number" class="form-control" id="duration" placeholder="Duration" name="duration">
    </div>

    <div class="form-group">
      <label for="flexibility">Flexibility (in days)</label>
      <input type="range" min="0" max="4" class="form-control" id="flexibility" placeholder="Flexibility" name="flexibility">
    </div>


    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>