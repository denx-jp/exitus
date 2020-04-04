FROM node:13.0.1-alpine as build

RUN apk add --no-cache python musl-dev gcc make g++ file alpine-sdk && \
    python -m ensurepip && \
    rm -r /usr/lib/python*/ensurepip && \
    pip install --upgrade pip setuptools && \
    rm -r /root/.cache


COPY package-lock.json /front/package-lock.json

COPY package.json /front/package.json

WORKDIR /front

RUN npm ci

FROM node:13.0.1-alpine

WORKDIR /front

COPY . /front

RUN rm -rf node_modules

COPY --from=build /front/node_modules /front/node_modules

CMD ["sh","-c","npm run dev"]

