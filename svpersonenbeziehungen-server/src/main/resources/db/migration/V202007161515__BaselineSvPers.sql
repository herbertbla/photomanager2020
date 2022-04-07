--------------------------------------------------
-- hibernate sequence / AUF KEINEN FALL LÖSCHEN!!!
--------------------------------------------------
declare
    v_count number;
begin
    -- Hibernate Sequence zu Ermittlung der IDs
    select count(*) into v_count
    FROM user_sequences
    WHERE UPPER(sequence_name) = UPPER('hibernate_sequence');

    if COALESCE(v_count,-1) <= 0 then
        EXECUTE IMMEDIATE 'CREATE SEQUENCE ' || UPPER('hibernate_sequence') || ' ';
        --START WITH 1 MINVALUE 1 MAXVALUE 1000000000000000 INCREMENT BY 1 NOCYCLE CACHE 20 NOORDER';
    end if;
end;
/
--create sequence REVISION_SEQ start with 1 increment by 1
--create table ACCESS_LOG_USER_SESSION (session_id varchar2(100 char) not null,
-- authorities varchar2(255 char), created timestamp not null, ip_address varchar2(20 char) not null,
-- server_id varchar2(30 char) not null, user_label varchar2(100 char) not null,
-- user_name varchar2(100 char) not null, primary key (session_id))


