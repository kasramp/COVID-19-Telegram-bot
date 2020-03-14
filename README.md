# COVID-19-Telegram-bot
A Telegram bot to get latest progress on COVID-19

## Architecture

The project is written based on Spring Boot and uses MySQL version 8.x. 
No Telegram library, framework or whatsoever is used in this project.
All the telegram integration is done through direct rest calls.

## How to set up the project

### Prerequisites

- JDK 11
- Docker and docker-compose

### Run in local

#### Start docker-compose

Bring the database up using `docker-compose`,

```bash
$ docker-compose -f docker-compose.yml up -d
```

#### Add tokens to `application.properties`

Set Telegram token in `application.properties`. 

Or alternatively export them as environment variable. For example,

```bash
$ export TELEGRAM_TOKEN=[telegram_token]
```

#### Run the application

Run the project in console,

```bash
$ ./mvnw spring-boot:run
```

#### Run Ngrok

Download Ngrok from [here](https://ngrok.com/download) and run it as follow,

```bash
$ ./ngrok http 8080
```

#### Update Telegram hook

Update the bot hook using `hook-update.sh`.

Before running the script, export the following environment variables,

```bash
$ export URL=[ngrok_url]
$ export TOKEN=[bot_token]
```

And finally run the script,

```bash
$ ./hook_update.sh
```

### Mimic production environment

To mimic the production environment, run the project with the `production` profile as follows,

```bash
$ ./mvnw spring-boot:run -Pproduction 
```

### Production deployment

To deploy the project to production, ensure the following environment variable is exported,

```bash
SPRING_PROFILES_ACTIVE = production
```

The rest of the process is more or less similar to run the project in local.


## Important notes

- In production profile, swagger-ui is disabled.
- Only API calls that come from Telegram servers are accepted, the rest is ignored, see `SecurityConfig.java`.

## Donate
You can always support, show appreciation by buying a cup of coffee :-)

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=C68PYFWLT332S)

## Contact
* kasra@madadipouya.com

## License
<p>
<img src="https://www.gnu.org/graphics/gplv3-127x51.png" alt="License"/>
</p>
COVID-19-Telegram-bot is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License version 3
as published by the Free Software Foundation.

COVID-19-Telegram-bot is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.  <http://www.gnu.org/licenses/>

Author(s):

© 2020 Kasra Madadipouya <kasra@madadipouya.com> 