/* test 하위의 resources에 본 파일을 만들었기 때문에 test가 실행될 때 만 실행됨
   main 하위에 만들경우 spring boot가 run 될 때마다 실행 됨
 */
/* 자동증가, User 도메인에 붙여준 @Generated는 추후 사용 예정*/
call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'hello', 'hello@gmail.com',  now(), now());

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@gmail.com',  now(), now());

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@daum.com',  now(), now());

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@naver.com',  now(), now());

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'hello', 'hello@daum.com',  now(), now());




