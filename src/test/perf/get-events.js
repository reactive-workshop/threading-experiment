import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
  http.get('http://localhost:8080/events');
}

export const options = {
  vus: 40,
  iterations: 80,
};
