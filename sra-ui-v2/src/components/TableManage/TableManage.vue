<template>
  <div>
    <n-card>
      <div>
        <n-form label-placement="left">
          <n-space><slot name="search"></slot></n-space>
        </n-form>
      </div>
      <div>
        <slot name="operate"></slot>
      </div>
    </n-card>

    <n-card style="margin-top: 3px">
      <n-space justify="center">
        <slot name="default"></slot>
        <slot name="page"></slot>
      </n-space>
    </n-card>

    <slot name="form"></slot>
  </div>
</template>
