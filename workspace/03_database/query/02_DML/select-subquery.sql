-- 가장 오래된 회원의 가입일
select min(created_at) from member;

-- 회원 정보 조회
select * from member;

-- 가장 오래전에 가입한 회원의 정보 조회 (서브쿼리 사용)
select *
from member
where created_at = (select min(created_at) from member)

-- 게시글을 하나라도 작성한 회원의 ID
select distinct member_id from post where member_id is not null;

-- id가 1, 2인 회원의 정보 조회
select *
from member
where id in(1,2);

-- 게시글을 하나라도 작성한 회원의 정보 조회
select *
from member
where id in (select distinct member_id from post where member_id is not null);

-- 게시글 조회(id, title)
select id, title from post;
-- 1번 게시글의 정보와 댓글 수 조회
select count(*) from reply where post_id = 1;
-- 각 게시글과 함께 각 게시글의 댓글 수 조회
select id, title, (select count(*) from reply where post_id = post.id) as reply_count
from post;
-- 각 게시글과 함께 각 게시글의 댓글 수 조회(조인)
select p.id,p.title,count(r.id)
from post p
left join reply r on p.id = r.post_id
group by p.id, p.title;

-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원 조회
-- 게시글을 한 건이라도 작성한 회원의 ID
select distinct member_id from post where member_id is not null;
-- 게시글을 한 건이라도 작성한 회원의 게시글 수
select member_id, count(*) as cnt
from post
where member_id is not null
group by member_id;
-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수
select avg(cnt)
from(
	select member_id, count(*) as cnt
	from post
	where member_id is not null
	group by member_id
) as sub;
-- 게시글을 한 건이라도 작성한 회원의 평균 게시글보다 많은 글을 작성한 회원 조회
select member_id, count(*) as post_count
from post
where member_id is not null
group by member_id
having count(*) > (select avg(cnt) -- 평균
	from(
		select member_id, count(*) as cnt
		from post
		where member_id is not null
		group by member_id
	) as sub
);