FROM golang:alpine as builder
RUN mkdir /build 
ADD . /build/
WORKDIR /build 
RUN go build -o appsample cmd/appsample/main.go

FROM alpine
RUN adduser -S -D -H -h /app appuser
USER appuser
COPY --from=builder /build/appsample /app/
WORKDIR /app
CMD ["./appsample"]
EXPOSE 8080

