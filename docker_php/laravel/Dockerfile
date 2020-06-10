FROM debian:buster
MAINTAINER fx@fx-world.de
ENV DEBIAN_FRONTEND noninteractive

#######################################################

RUN apt-get update && \
	apt-get install -y apt-utils curl gnupg apt-transport-https && \
#	echo 'deb http://packages.dotdeb.org buster all' > /etc/apt/sources.list.d/dotdeb.list && \
#	curl http://www.dotdeb.org/dotdeb.gpg | apt-key add - && \ 
	apt-get update && \
	apt-get install -y zip unzip \		
		apache2 \
		libapache2-mod-php php-cli php-common php-json \ 
		php-opcache php-xml php-mysql php-gd php-readline \
		php-tokenizer php-curl php7.3-common php-cli php-intl \
		php-mbstring php-bcmath php-imap php-xml php-zip \
		libapache2-mod-svn && \
	apt-get clean && \
	a2enmod rewrite && \
	mkdir /apache && \
	mkdir /apache/sites-enabled && \
	mkdir /apache/www && \	
	mkdir /apache/logs && \
	rm -r /etc/apache2/sites-enabled && \
	rm -r /var/www && \
	rm -r /var/log/apache2 && \
	ln -s /apache/sites-enabled /etc/apache2/ && \
	ln -s /apache/www /var/ && \
	ln -s /apache/logs /var/log/apache2
	
COPY ./composer* /bin/

RUN chmod ugo+x /bin/composer && \
	echo 'export PATH="$PATH:$HOME/.composer/vendor/bin"' >> ~/.bashrc
RUN	php /bin/composer.phar global require laravel/installer

ENV APACHE_RUN_USER=www-data \
	APACHE_RUN_GROUP=www-data \
	APACHE_LOG_DIR=/apache/logs

CMD /usr/sbin/apache2ctl -D FOREGROUND
EXPOSE 80
