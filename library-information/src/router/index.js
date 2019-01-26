import Vue from 'vue'
import Router from 'vue-router'

import SignInPage from '../pages/SignIn'
import AdminBookOverviewPage from '../pages/AdminBookOverview'
import UserBookOverviewPage from '../pages/UserBookOverview'
import UserOverviewPage from '../pages/UserOverview'
import OnlineReaderPage from '../pages/BookOnlineReader'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SignInPage',
      component: SignInPage
    },
    {
      path: '/book/edit',
      name: 'AdminBookOverviewPage',
      component: AdminBookOverviewPage
    },
    {
      path: '/book',
      name: 'UserBookOverviewPage',
      component: UserBookOverviewPage
    },
    {
      path: '/user',
      name: 'UserOverviewPage',
      component: UserOverviewPage
    },
    {
      path: '/reader',
      name: 'OnlineReaderPage',
      component: OnlineReaderPage
    }
  ]
})
