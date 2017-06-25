import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './modules/login/login.component';

const routes: Routes = [
  // 以后在这里改动配置
  { path: '', pathMatch: 'full', redirectTo: '/toLogin' },
  { path: 'toLogin',  component: LoginComponent }
];
// { path: 'detail/:id', component: DetailComponent }

// 将路由配置导出为 appRouting 以供调用, 子模块中的路由使用 forChild 而不是 forRoot
export const appRouting = RouterModule.forRoot(routes);
