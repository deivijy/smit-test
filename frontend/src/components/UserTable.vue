<template>
  <ul>
    <li v-for="contact in contacts" :key="contact.id" data-test="post">
      {{ contact.firstName}}
    </li>
  </ul>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      contacts: []
    }
  },
  mounted() {
    fetch('http://localhost:8080/api/v1/contacts')
      .then((res) => res.json())
      .then((data) => this.contacts = data)
      .catch((err) => console.error(err));
  }
}
</script>