package io.github.asyncronous.apothecary.poison

trait Poison{
  def id(): String;
  def maxUses(): Int;
}