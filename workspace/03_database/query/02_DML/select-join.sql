-- 게시글 목록 조회
select * from post

-- 모든 게시글의 id, member_id, title, view_count 컬럼 조회
select member_id, title, view_count from post;

-- 모든 게시글의 id, title, view_count, 작성자 이름, 작성자 이메일 컬럼 조회
select post.id, member_id, title, view_count, member.name, member.email 
from post
inner join member on post.member_id = member.id;

-- 모든 게시글의 id, title, view_count, 작성자 이름, 작성자 이메일 컬럼 조회 (alias 사용)
select p.id, p.member_id, p.title, p.view_count unt, m.name, m.email 
from post p
inner join member as m on p.member_id = m.id;

-- 모든 댓글 조회
select * from reply;

-- 모든 댓글의 id, content, member_id, post_id 조회
select id, content, member_id, post_id from reply;

-- 모든 댓글의 id, content, member_id, post_id, 작성자 이름, 게시글 제목 조회
select reply.id, reply.content, reply.member_id, post_id 
from reply
inner join member on reply.member_id = member.id
inner join post on reply.post_id = post.id;

-- 게시글 기준으로 정렬
select post.title 게시글, reply.content 댓글, member.name 댓글작성자
from reply
inner join member on reply.member_id = member.id
inner join post on reply.post_id = post.id
order by post.id desc;

-- left outer join
-- 모든 게시글의 id, title, view_count, 작성자 이름, 작성자 이메일 컬럼 조회 (alias 사용)
select p.id, p.member_id, p.title, p.view_count unt, m.name, m.email 
from post p
left join member as m on p.member_id = m.id;

-- 전체 회원 목록과 각 회원이 작성한 게시글 수를 조회(게시글을 작성하지 않은 회원도 포함 되어야 함)
-- 전체 회원 목록 조회
select * from member;
-- 필요한 컬럼만 추출
select m.id, m.name, count(p.id) post_count 
from member m
left join post p on m.id = p.member_id
group by m.id, m.name;


-- right outer join
-- 모든 게시글의 id, title, view_count, 작성자 이름, 작성자 이메일 컬럼 조회 (alias 사용)
select p.id, p.member_id, p.title, p.view_count unt, m.name, m.email 
from post p
right join member as m on p.member_id = m.id;

select p.id, p.member_id, p.title, p.view_count unt, m.name, m.email 
from member m
left join post as p on p.member_id = m.id;

-- full outer join (MySQL은 지원하지 않음 -> union으로 대체)
select m.id as member_id, m.name, p.title
from member m
left join post p on m.id = p.member_id
union
select m.id as member_id, m.name, p.title
from member m
right join post p on m.id = p.member_id;

-- self join
-- 회원명과 추천인명을 조회
select m1.name 회원명, m1.recommender_id, IFNULL(m2.name, '-')  추천인명
from member m1
left join member m2 on m1.recommender_id = m2.id;
-- inner join member m2 on m1.recommender_id = m2.id; -- 추천인이 있는 회원명과 추천인명을 조회


