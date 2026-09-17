# Elsa API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ElsaService`
Operation count: 1

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ElsaService` trong Swagger.

## Endpoints

### `POST /v1/elsa`

- Operation ID: `ElsaService_Proxy`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `apiHttpBody` | Message that represents an arbitrary HTTP body. It should only be used for payload formats that can't be represented as JSON, such as raw binary or an HTML page. This message can be used both in streaming and non-streaming API methods in the request as well as the response. It can be used as a top-level request field, which is convenient if one wants to extract parameters from either the URL or HTTP template into the request fields and also want access to the raw HTTP body. Example: message GetResourceRequest { // A unique request id. string request_id = 1; // The raw HTTP body is bound to this field. google.api.HttpBody http_body = 2; } service ResourceService { rpc GetResource(GetResourceRequest) returns (google.api.HttpBody); rpc UpdateResource(google.api.HttpBody) returns (google.protobuf.Empty); } Example with streaming methods: service CaldavService { rpc GetCalendar(stream google.api.HttpBody) returns (stream google.api.HttpBody); rpc UpdateCalendar(stream google.api.HttpBody) returns (stream google.api.HttpBody); } Use of this type only changes how the request and response bodies are handled, all other features will continue to work unchanged. |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `apiHttpBody` |
| `default` | An unexpected error response. | `googleRpcStatus` |

