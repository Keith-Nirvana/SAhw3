import Vue from 'vue'
import Router from 'vue-router'

import SignInPage from '../pages/SignIn'
import AdminStatisticPage from '../pages/AdminStatistic'
import AdminBookOverviewPage from '../pages/AdminBookOverview'
import OfficeBookOverviewPage from '../pages/OfficeBookOverview'
import UserBookOverviewPage from '../pages/UserBookOverview'
import UserOverviewPage from '../pages/AdminUserOverview'
import AdminOnlineReaderPage from '../pages/AdminBookOnlineReader'
import UserOnlineReaderPage from '../pages/UserBookOnlineReader'
import UserInfoPage from '../pages/UserInfo'
import BorrowRecordPage from '../pages/BorrowRecord'
import AdminMessagePage from '../pages/AdminMessage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SignInPage',
      component: SignInPage
    },
    {
      path: '/admin/book',
      name: 'AdminBookOverviewPage',
      component: AdminBookOverviewPage
    },
    {
      path: '/user/book',
      name: 'UserBookOverviewPage',
      component: UserBookOverviewPage
    },
    {
      path: '/office/book',
      name: 'OfficeBookOverviewPage',
      component: OfficeBookOverviewPage
    },
    {
      path: '/admin/user',
      name: 'UserOverviewPage',
      component: UserOverviewPage
    },
    {
      path: '/user/info',
      name: 'UserInfoPage',
      component: UserInfoPage
    },
    {
      path: '/admin/reader',
      name: 'AdminOnlineReaderPage',
      component: AdminOnlineReaderPage
    },
    {
      path: '/user/reader',
      name: 'UserOnlineReaderPage',
      component: UserOnlineReaderPage
    },
    {
      path: '/admin/statistic',
      name: 'AdminStatisticPage',
      component: AdminStatisticPage
    },
    {
      path: '/user/record',
      name: 'BorrowRecordPage',
      component: BorrowRecordPage
    },
    {
      path: '/admin/message',
      name: 'AdminMessagePage',
      component: AdminMessagePage
    },
  ]
})
