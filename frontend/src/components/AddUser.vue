<template>
    <form @submit.prevent>
        <h2>Add new contact</h2>
        <label>Name</label>
        <input type="text" v-model="contact.firstName">
        <label>Last name</label>
        <input type="text" v-model="contact.lastName">
        <label>Secret code</label>
        <input type="text" v-model="contact.secretCode">
        <label>Phone number</label>
        <input type="text" v-model="contact.phoneNumber">
        <button @click="addContact">Add contact</button>
    </form>
    
</template>

<script>
    export default {
        data() {
            return {
                contact: {
                    firstName: '',
                    lastName: '',
                    secretCode: '',
                    phoneNumber: ''
                },
            }
        },
        methods: {
            addContact() {
                fetch('http://localhost:8080/api/v1/contacts', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.contact)
                }).then(() => window.location.reload());
            }  
        }
    }
</script>