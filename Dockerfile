FROM golang:alpine as builder
RUN mkdir /build 
ADD . /build/
WORKDIR /build 
RUN go build -o apps_sample cmd/apps_sample/main.go

FROM alpine
RUN adduser -S -D -H -h /app appuser
USER appuser
COPY --from=builder /build/apps_sample /app/
WORKDIR /app
CMD ["./apps_sample"]
EXPOSE 8080

