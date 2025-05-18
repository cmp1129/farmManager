// Saludo dinámico
document.addEventListener("DOMContentLoaded", function () {
  const greeting = document.getElementById("greeting");
  const now = new Date();
  const hour = now.getHours();

  let message;
  if (hour >= 6 && hour < 12) {
    message = "Buenos días granjer@, ¿qué deseas gestionar hoy?";
  } else if (hour >= 12 && hour < 20) {
    message = "Buenas tardes granjer@, ¿qué deseas gestionar hoy?";
  } else {
    message = "Buenas noches granjer@, ¿qué deseas gestionar hoy?";
  }

  greeting.textContent = message;
});

// Fecha y hora en tiempo real
setInterval(function () {
  const now = new Date();
  const timeString = now.toLocaleTimeString();
  const dateString = now.toLocaleDateString();

  document.getElementById(
    "datetime"
  ).textContent = `${dateString} ${timeString}`;
}, 1000);

// Pronóstico ficticio aleatorio con emojis
function updateWeather() {
  const weatherOptions = [
    { text: "Soleado", icon: "☀️" },
    { text: "Nublado", icon: "☁️" },
    { text: "Lluvia", icon: "🌧️" },
    { text: "Tormenta", icon: "⛈️" },
    { text: "Niebla", icon: "🌫️" },
  ];

  const randomWeather =
    weatherOptions[Math.floor(Math.random() * weatherOptions.length)];

  document.getElementById("weather-text").textContent = randomWeather.text;
  document.getElementById("weather-icon").textContent = randomWeather.icon;
}

// Actualiza cada 30 segundos
setInterval(updateWeather, 30000);
updateWeather();
