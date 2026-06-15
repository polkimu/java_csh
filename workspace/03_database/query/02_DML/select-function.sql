-- 회원 이름 조회
select name, email, concat(name, '(', email, ')') as member_info 
from member;

-- 각 회원의 이메일 바이트 수 조회
select email, length('hello'), length('안녕하세요'), length(email) as email_length
from member;

select content, replace (content, '안녕하세요', 'HI!') as replaced_content
from post
where content like '%안녕하세요%';

-- 게시글 본문의 첫 10 글자만 미리보기로 가져오기 (잘린 뒷 부분은 ...으로 가져오세요) 
select title, concat(substring(title, 1, 10), '...') as preview
from post;

-- 이메일을 소/대문자로 조회
select email, lower(email) as email_lower, upper(email) as email_upper
from member;

-- 이메일 앞뒤 공백 제거
select email, trim(email) as trimmed_email
from member;

-- 현재 날짜와 시간 조회
select now() as current_datetime;

-- 게시글 작성일을 연-월-일 형태로 조회
SELECT id, title, DATE_FORMAT(created_at, '%y년 %m월 %d일 %h시 %i분 %s초') AS write_date
FROM post;

-- 현재 날짜만 조회
select curdate() as cur_date;

-- 오늘 작성 게시글만 조회
select id, title, created_at
from post
where created_at >= curdate();

-- 최근 7일 이내에 가입한 회원 조회s
select id, name, created_at, curdate(), date_sub(curdate(), interval 7 day) as before_7days
from member
where created_at >= date_sub(curdate(), interval 7 day);

-- 가입한지 1개월이 지난 회원 정보 조회
select id, name, created_at, curdate(), date_sub(curdate(), interval 1 month) as before_1month
from member
where created_at <= date_sub(curdate(), interval 1 month)

-- 가입한지 35일 12시간이 지난 회원 조회
select id, name, created_at, curdate(), date_sub(curdate(), interval '35 12' day_hour) as before_1month
from member
where created_at <= date_sub(curdate(), interval '35 12' day_hour);

-- 각 회원의 가입 경과 일수를 조회
select name, created_at, datediff(curdate(),created_at)
from member;

-- id = 3인 회원의 모든 게시글의 조회 수 조회
select member_id, view_count
from post
where member_id = 3;

-- id = 3인 회원의 모든 게시글의 총 게시글 수 조회
select member_id, count(*) as total_count
from post
where member_id = 3;

-- id = 3인 회원의 모든 게시글의 총 조회수
select member_id, count(*) as total_counts, sum(view_count) as total_views,
avg(view_count ) as avg_views, min(view_count) as min_view, max(view_count) as max_view
from post

-- 전화번호가 NULL인 회원은 '미등록'으로 표시하여 조회
SELECT name, IFNULL(phone, '미등록') AS phone
FROM member;

-- 전화번호가 NULL이면 이메일을, 이메일도 NULL이면 '연락처 없음'으로 조회
SELECT name, IFNULL(phone, IFNULL(email, '연락처 없음')) AS contact
FROM member;
SELECT name, COALESCE(phone, email, '연락처 없음') AS contact
FROM member;
SELECT name, IF(phone IS NULL, IF(email IS NULL, '연락처 없음', email), phone) AS phone_status
FROM MEMBER;

-- 전화번호 등록 여부에 따라서 상태를 다르게 표시
SELECT name, IF(phone IS NULL, '연락처 없음', '연락처 있음') AS phone_status
FROM MEMBER;

-- 가입년도가 1년이 넘었으면 '우수 회원', 1달이 넘었으면 '일반 회원', 그렇지 않으면 '신규 회원'을 출력
select 
	name, 
	created_at,
	case
		when created_at < date_sub(now(), interval 1 year) then '우수 회원'
		when created_at < date_sub(now(), interval 1 month) then '일반 회원'
		else '신규 회원'
	end as member_grade
from member;