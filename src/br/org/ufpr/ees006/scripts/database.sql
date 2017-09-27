CREATE SCHEMA `javabasic` ;

CREATE TABLE IF NOT EXISTS `javabasic`.`cliente` (
  `id` INT(11) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `sobrenome` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `uk01` (`cpf` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `javabasic`.`produto` (
  `id` INT(11) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `produtocol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `javabasic`.`pedido` (
  `id` INT(11) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk01_idx` (`id_cliente` ASC),
  CONSTRAINT `fk01`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `javabasic`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `javabasic`.`item_do_pedido` (
  `id_pedido` INT(11) NOT NULL,
  `id_produto` INT(11) NOT NULL,
  `qtdade` INT(11) NOT NULL,
  INDEX `fk_item_do_pedido_produto1_idx` (`id_produto` ASC),
  INDEX `fk_item_do_pedido_pedido1_idx` (`id_pedido` ASC),
  PRIMARY KEY (`id_pedido`, `id_produto`),
  CONSTRAINT `fk_item_do_pedido_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `javabasic`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_do_pedido_pedido1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `javabasic`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

