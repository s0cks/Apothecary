package io.github.asyncronous.apothecary.api

trait Poison{
  def id(): String;
  def maxUses(): Int;
  def uid(): Int;
}