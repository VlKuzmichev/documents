DROP TABLE IF EXISTS documents;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS doc_types;
DROP TABLE IF EXISTS doc_units;
DROP TABLE IF EXISTS units;
DROP TABLE IF EXISTS services;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

-- Пользователи(авторизация в системе)
CREATE TABLE users
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_name VARCHAR NOT NULL,
    password  VARCHAR NOT NULL
);
-- Пользователей с одинаковым логином нет
CREATE UNIQUE INDEX users_unique_user_name_idx ON users (user_name);

CREATE TABLE doc_types
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL -- название типа документа
);
-- Типа документа с одинаковым названием нет
CREATE UNIQUE INDEX doc_types_unique_name_idx ON doc_types (name);

-- Справочник тмц, услуг
CREATE TABLE services
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL -- наименование услуги, тмц
);
-- уникальное наименование услуги, тмц
CREATE UNIQUE INDEX services_unique_name_idx ON services (name);

-- Справочник единиц измерения
CREATE TABLE units
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL -- наименование единицы измерения
);
-- уникальное наименование единицы изменения
CREATE UNIQUE INDEX units_unique_name_idx ON units (name);

CREATE TABLE doc_units
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    service_id INTEGER NOT NULL, -- поле справочника тмц, услуги
    unit_id    INTEGER NOT NULL, -- поле справочника единиц измерения
    FOREIGN KEY (service_id) REFERENCES services (id) ON DELETE CASCADE,
    FOREIGN KEY (unit_id) REFERENCES units (id) ON DELETE CASCADE
);
-- услуги с такой единицей измерения одинаковой нет
CREATE UNIQUE INDEX doc_units_unique_service_id_unit_id_idx ON doc_units (service_id, unit_id);

-- Сотрудники
CREATE TABLE employees
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    org_id    Integer NOT NULL, -- (для уникальности таб. номер или др., для примера)
    full_name VARCHAR NOT NULL  -- ФИО сотрудника
);
-- Сотрудников с одинаковым табельным номером нет
CREATE UNIQUE INDEX employees_unique_org_id_idx ON employees (org_id);

-- Документы
CREATE TABLE documents
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date_time   TIMESTAMP NOT NULL, -- время создания документа
    value       VARCHAR   NULL,     -- значение(предположительно текст, уточнить назначение)
    sum         INTEGER   NOT NULL, -- сумма документа
    doc_type_id INTEGER   NOT NULL, -- поле таблицы справочника типов документов(сч.фактуры, накладные)
    doc_unit_id INTEGER   NOT NULL, -- поле таблицы учетная единица документа(справочник, ед. измерения)
    employee_id INTEGER   NOT NULL, -- поле таблицы сотрудники
    FOREIGN KEY (doc_type_id) REFERENCES doc_types (id) ON DELETE CASCADE,
    FOREIGN KEY (doc_unit_id) REFERENCES doc_units (id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employees (id) ON DELETE CASCADE
);
-- Необходимо уточнение по уникальности документа(каких совпадений не должно быть)
-- Например в одно время с одинаковым значением:
-- CREATE UNIQUE INDEX documents_unique__date_time_value_idx ON documents (date_time, value);
