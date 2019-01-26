import Vue from 'vue'
import Router from 'vue-router'

import SignInPage from '../pages/SignIn'
import BookOverviewPage from '../pages/BookOverview'
import UserOverviewPage from '../pages/UserOverview'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SignInPage',
      component: SignInPage
    },
    {
      path: '/book',
      name: 'BookOverviewPage',
      component: BookOverviewPage
    },
    {
      path: '/user',
      name: 'UserOverviewPage',
      component: UserOverviewPage
    },
  ]
})
