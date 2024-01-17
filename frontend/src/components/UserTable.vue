<template>
  <input v-model="searchQuery" placeholder="Search contacts...">
  <div>
    <button @click="changePage(pageable.pageNumber - 1)" :disabled="pageable.pageNumber === 0">Previous</button>
    <span>Page {{ pageable.pageNumber + 1 }} of {{ totalPages }}</span>
    <button @click="changePage(pageable.pageNumber + 1)" :disabled="pageable.pageNumber >= totalPages - 1">Next</button>
    <select v-model="pageable.pageSize" @change="changePerPage">
        <option value="10">10</option>
        <option value="25">25</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>
  </div>
  <table>
    <thead>
        <tr>
          <th>
            First Name
            <span @click="sort('firstName')">
              {{ sortField === 'firstName' ? (sortDirection === 'asc' ? '↑' : '↓') : '⇅' }}
            </span>
          </th>
          <th>
            Last Name
            <span @click="sort('lastName')">
              {{ sortField === 'lastName' ? (sortDirection === 'asc' ? '↑' : '↓') : '⇅' }}
            </span>
          </th>
          <th>Secret Code</th>
          <th>Phone Number</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="contact in content" :key="contact.id" data-test="contact">
          <td>{{ contact.firstName }}</td>
          <td>{{ contact.lastName }}</td>
          <td>{{ contact.secretCode }}</td>
          <td>{{ contact.phoneNumber }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>

export default {
  data() {
    return {
      content: [],
      sortField: 'firstName',
      sortDirection: 'asc',
      searchQuery: '',
      totalPages: 0,
      pageable: {
        pageNumber: 0,
        pageSize: 10,
      }
    }
  },
  watch: {
    searchQuery() {
      this.fetchContacts();
    },
  },
  mounted() {
    this.fetchContacts();
  },
  methods: {
    fetchContacts() {
      const url = new URL('http://localhost:8080/api/v1/contacts');

      url.searchParams.append('sortField', this.sortField);
      url.searchParams.append('sortDirection', this.sortDirection);
      url.searchParams.append('searchQuery', this.searchQuery);
      url.searchParams.append('page', this.pageable.pageNumber);
      url.searchParams.append('size', this.pageable.pageSize);

      fetch(url)
        .then(res => res.json())
        .then(data => {
          this.content = data.content;
          this.totalPages = data.totalPages;
          this.pageSize = data.pageable.pageSize;
        })
        .catch(err => console.error(err));
    },
    sort(field) {
      if (this.sortField === field) {
        this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
      } else {
        this.sortField = field;
        this.sortDirection = 'asc';
      }
      this.fetchContacts();
    },
    searchContacts() {
      this.fetchContacts();
    },
    changePage(page) {
      if (page >= 0 && page < this.totalPages) {
        this.pageable.pageNumber = page;
        this.fetchContacts();
      }
    },
    changePerPage() {
      this.pageable.pageNumber = 0;
      this.fetchContacts();
    }
  }
}
</script>